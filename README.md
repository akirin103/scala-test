## scala-test

### 環境構築(mac)

[ゼロから始めるScala (環境構築 mac)](https://qiita.com/sudachi0114/items/ea0b5eef5ffd3e37fdd3)

[環境変数JAVA_HOMEの確認と設定方法を現役エンジニアが解説【初心者向け】](https://techacademy.jp/magazine/24230)

### 実行方法(scala)

```
# コンパイルして実行
$ scalac Main.scala
$ scala Main

# コンパイルしないで実行
$ scala Main.scala
```

### sbt

#### sbtとは
コンパイルはもちろん、プロジェクトに必要なパッケージやライブラリの管理を行ってくれる強力なツール

[【Scala初心者向け】sbtを触ってみよう！](https://www.casleyconsulting.co.jp/blog/engineer/104/)

```
# コンパイル
$ sbt compile

# 実行
$ sbt run
```

### configの読み込み

[config](https://github.com/lightbend/config)

[Scala の typesafe config がいい感じに applicatoon.conf を読んでくれない](https://www.utakata.work/entry/2017/10/28/100000)

[Playframework application.confに環境変数をbindする](https://www.letitride.jp/entry/2020/06/02/221531)

### ORM Slick

[Slick](https://scala-slick.org/)

### postgresql
#### DB、スキーマ作成〜権限設定まで

- スーパーユーザでログインする。  
```sh
$ psql \
   --host=localhost \
   --port=5432 \
   --username=postgres \
   --password \
   --dbname=postgres

-> CREATE DATABASE test01;
# 現在のデータベースを変更する。(postgres => test01)
-> \c test01;
# 作成済みのテーブル一覧を取得する
-> \dt
```

### dockerで構築したpostgresqlにlocalhostで接続したら認証で落ちる件
dockerコンテナを立てた後、DBにプログラムから接続すると下記のエラーで落ちた。  
```
認証型 10 はサポートされません。pg_hba.conf...
```

```
$ apt get update
$ apt install iproute2
# IPアドレスを確認する
$ ip address show
```

```
# pg_hba.conf
# dockerコンテナのIPを登録する。(172.23.0.2/16)
host    all             all             172.23.0.2/16            password
```
[Ubuntu18.04で自分自身のIPアドレスを調べる(IPコマンド)](https://k99-tech.com/blog/archives/1162)

[Allow docker container to connect to a local/host postgres database](https://stackoverflow.com/questions/31249112/allow-docker-container-to-connect-to-a-local-host-postgres-database)
