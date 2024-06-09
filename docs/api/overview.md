# APIリファレンス

こちらはForemのAPIリファレンスです。このセクションでは、主要なクラスとその機能について説明します。

## クラス一覧

<h3 id="ForemActivity">ForemActivity</h3>

`ForemActivity`はJavaでレイアウトを行うために必要なクラスです。

<h3 id="HorizontalLayout">HorizontalLayout</h3>

`HorizontalLayout`はUIを横並びに配置するためのクラスです。
既存のレイアウト方法では、LinearLayoutを作成し、その後LinearLayoutのorientationをhorizontalに変更する必要がありましたが、LinearLayoutに代わって、HorizontalLayoutを使用することで、UIを横並びにすることができるようになります。

<h3 id="VerticalLayout">VerticalLayout</h3>

`VerticalLayout`はUIを縦並びに配置するためのクラスです。
既存のレイアウト方法では、LinearLayoutを作成し、その後LinearLayoutのorientationをverticalに変更する必要がありましたが、LinearLayoutに代わって、VerticalLayoutを使用することで、UIを縦並びにすることができるようになります。

<h3 id="Background">Background</h3>

`Background`はUI要素の背景レイアウトを行うためのクラスです。
drawableにXMLファイルで記述していた背景レイアウトをJavaファイルに記述できます。
#### サンプルコード
```java
this.<TextView>create(()->{
  layout(match_parent,match_parent);
  text("sample");
  new Background(){{
    setColor(Color.RED);
    setCornerRadius(100);
  }};
});
```
