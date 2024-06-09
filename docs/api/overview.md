# APIリファレンス

こちらはForemのAPIリファレンスです。こちらでは、主要なクラスとその機能について説明します。

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
        this.<TextView>create(()->{
            layout(match_parent,match_parent);
            text("sample");
        });
    }
}
```
また、要素を生成する際は、以下のように記述します。  
```java
this.<Viewクラス>create(()->{
    // 要素の属性設定
});
```

<h3 id="HorizontalLayout">HorizontalLayout</h3>

`HorizontalLayout`はUIを横並びに配置するためのクラスです。  
既存のレイアウト方法では、LinearLayoutを作成し、その後LinearLayoutのorientationをhorizontalに変更する必要がありましたが、LinearLayoutに代わって、HorizontalLayoutを使用することで、UIを横並びにすることができるようになります。  
以下のサンプルコードでは、createメソッドで要素の属性設定を行い、続くrenderメソッドでHorizontalLayoutの子要素のレイアウトを記述しています。
#### サンプルコード
```java
this.<HorizontalLayout>create(()->{
    layout(match_parent,match_parent);
}).render(()->{
    this.<TextView>create(()->{
        layout(wrap_content,wrap_content);
        text("sample text");
    });
    this.<Button>create(()->{
        layout(wrap_content,wrap_content);
        text("sample button");
    });
});
```
以下は、要素の属性設定や子要素のレイアウトを省略したコードです。
```java
this.<HorizontalLayou>create(()->{
    // 要素の属性設定
}).render(()->{
    // 子要素のレイアウト
});
```

<h3 id="VerticalLayout">VerticalLayout</h3>

`VerticalLayout`はUIを縦並びに配置するためのクラスです。  
既存のレイアウト方法では、LinearLayoutを作成し、その後LinearLayoutのorientationをverticalに変更する必要がありましたが、LinearLayoutに代わって、VerticalLayoutを使用することで、UIを縦並びにすることができるようになります。  
以下のサンプルコードでは、createメソッドで要素の属性設定を行い、続くrenderメソッドでVerticalLayoutの子要素のレイアウトを記述しています。
#### サンプルコード
```java
this.<VerticalLayout>create(()->{
    layout(match_parent,match_parent);
}).render(()->{
    this.<TextView>create(()->{
        layout(wrap_content,wrap_content);
        text("sample text");
    });
    this.<Button>create(()->{
        layout(wrap_content,wrap_content);
        text("sample button");
    });
});
```
以下は、要素の属性設定や子要素のレイアウトを省略したコードです。
```java
this.<VerticalLayout>create(()->{
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
this.<TextView>create(()->{
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
this.<TextView>create(()->{
    layout(match_parent, match_parent);
    text("sample");
    reusableBackground.export();
});
```
