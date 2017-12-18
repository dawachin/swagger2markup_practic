# コマンドまとめ

## gradle環境

#### ライセンス一覧を生成する
[license-gradle-plugin](https://github.com/hierynomus/license-gradle-plugin)

- ``gradle downloadLicenses``

#### オフラインパッケージを生成する
[Gradleでオフラインビルドの方法を考えてみた](http://wadahiro.hatenablog.com/entry/20120324/1332562767)

- ``gradle wrapper``
- ``gradle releaseSource``

実行すると、build/distrivutions と　build/offline にjarファイルとpropertiesが生成される。


## gradlew環境(do not need gradle)

#### 静的文章を発行する

- ``gradlew asciidoctor``
