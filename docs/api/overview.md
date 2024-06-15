# APIリファレンス

こちらはForemのAPIリファレンスです。主要なクラスとその使用方法について説明します。

## クラス一覧

<h3 id="ForemActivity">ForemActivity</h3>

`ForemActivity`はJavaでレイアウトを行うために必要なクラスです。  
基本的には、renderメソッド内にレイアウトと処理を記述していきます。  
以下のサンプルコードより下のクラスでは、renderメソッド内に記述していることを前提に説明を進めていきます。
#### サンプルコード
```java
public class SampleActivity extends ForemActivity{
    @Override
    public void render(Root root){
        $.<TextView>create(()->{
            layout(match_parent,match_parent);
            text("sample");
        });
    }
}
```
また、要素を生成する際は、以下のように記述します。  
```java
$.<Viewクラス>create(()->{
    // 要素の属性設定
});
```

<h3 id="HorizontalLayout">HorizontalLayout</h3>

`HorizontalLayout`はUIを横並びに配置するためのクラスです。  
既存のレイアウト方法では、LinearLayoutを作成し、その後LinearLayoutのorientationをhorizontalに設定する必要がありましたが、LinearLayoutに代わって、HorizontalLayoutを使用することで、UIを横並びにすることが可能になります。
以下のサンプルコードでは、createメソッドで要素の属性設定を行い、続くrenderメソッドでHorizontalLayoutの子要素のレイアウトを記述しています。
#### サンプルコード
```java
$.<HorizontalLayout>create(()->{
    layout(match_parent,match_parent);
}).render(()->{
    $.<TextView>create(()->{
        layout(wrap_content,wrap_content);
        text("sample text");
    });
    $.<Button>create(()->{
        layout(wrap_content,wrap_content);
        text("sample button");
    });
});
```
以下は、要素の属性設定や子要素のレイアウトを省略したコードです。
```java
$.<HorizontalLayou>create(()->{
    // 要素の属性設定
}).render(()->{
    // 子要素のレイアウト
});
```

<h3 id="VerticalLayout">VerticalLayout</h3>

`VerticalLayout`はUIを縦並びに配置するためのクラスです。  
既存のレイアウト方法では、LinearLayoutを作成し、その後LinearLayoutのorientationをverticalに設定する必要がありましたが、LinearLayoutに代わって、VerticalLayoutを使用することで、UIを縦並びにすることが可能になります。
以下のサンプルコードでは、createメソッドで要素の属性設定を行い、続くrenderメソッドでVerticalLayoutの子要素のレイアウトを記述しています。
#### サンプルコード
```java
$.<VerticalLayout>create(()->{
    layout(match_parent,match_parent);
}).render(()->{
    $.<TextView>create(()->{
        layout(wrap_content,wrap_content);
        text("sample text");
    });
    $.<Button>create(()->{
        layout(wrap_content,wrap_content);
        text("sample button");
    });
});
```
以下は、要素の属性設定や子要素のレイアウトを省略したコードです。
```java
$.<VerticalLayout>create(()->{
    // 要素の属性設定
}).render(()->{
    // 子要素のレイアウト
});
```

<h3 id="Background">Background</h3>

`Background`はUI要素の背景レイアウトを行うためのクラスです。  
drawableにXMLファイルで記述していた背景レイアウトをJavaファイルに記述できます。  
しかし、インスタンスを生成すると、現在生成中のViewに適応されてしまうため、再使用は不可能になっています。
#### サンプルコード
```java
$.<TextView>create(()->{
    layout(match_parent, match_parent);
    text("sample");
    new Background(){{
        setColor(Color.RED);
        setCornerRadius(100);
    }};
});
```

<h3 id="ReusableBackground">ReusableBackground</h3>

`ReusableBackground`はUI要素の背景レイアウトを行うためのクラスです。  
drawableにXMLファイルで記述していた背景レイアウトをJavaファイルに記述できます。  
また、再使用可能なように設計されており、複数回使用する場合は、こちらのクラスを使用することが推奨されています。
#### サンプルコード
```java
var reusableBackground = new ReusableBackground(){{
    setColor(Color.RED);
    setCornerRadius(100);
}};
$.<TextView>create(()->{
    layout(match_parent, match_parent);
    text("sample");
    reusableBackground.export();
});
```


<h3 id="ForemComponent">ForemComponent</h3>

`ForemComponent`は画面に描画されるコンポーネントを作成するためのクラスです。

#### 引数なしの場合のサンプルコード
以下のサンプルコードを実行すると、`sample`というTextViewが描画されます。
```java
// 引数なしのコンポーネントを作成
var sampleComponent = component(()->{
    $.<TextView>create(()->{
        layout(wrap_content,wrap_content);
        text("sample");
    });
});
// sampleComponentのexportを呼び出すことで、sampleComponentで実装した描画処理が実行される。
sampleComponent.export();
```
#### 引数ありの場合のサンプルコード
以下のサンプルコードを実行すると、`sample6`というTextViewが描画されます。

```java
// Stringクラスを引数として受け取るコンポーネントを作成
var sampleComponent = component(String.class, arg -> {
    $.<TextView>create(() -> {
        layout(wrap_content, wrap_content);
        text(arg + arg.length());
    });
});

// sampleComponentのexportにStringを渡すことで、sampleComponentで実装した描画処理が実行される。
sampleComponent.export("sample");
``` 

<h3 id="Arg">Arg</h3>

`Arg`はローカルな引数を作成するためのクラスです。  
一般的には、コンポーネントの引数を設定するためにArgクラスを使用します。  
以下のサンプルコードを実行すると、`10sample`というTextViewが描画されます。
#### サンプルコード
```java
// new Arg(){変数宣言}によって、引数を設定できる
var sampleComponent = component(new Arg(){
    int a;
    String b;
}, arg -> {
    $.<TextView>create(() -> {
        layout(wrap_content, wrap_content);
        // 受け取ったargのa,bを使用
        text(arg.a + arg.b);
    });
});

// [arg.引数名 = 値]で、引数を設定し、sampleComponentで実装した描画処理を実行する。
sampleComponent.export(arg->{
    arg.a = 10;
    arg.b = "sample";
});

```
