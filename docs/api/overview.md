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
<h3 id="Component">Component</h3>

`Component`はコンポーネントベースで開発を行うためのクラスです。  
従来のAndroidStudioでは、Fragmentクラスが似た役割を果たしていました。  
以下のサンプルコードを実行すると、テキストが"sample",テキストサイズが30のTextViewが描画されます。
#### サンプルコード
#### SampleComponent.java
```java
public class SampleComponent extends Component {
    // 引数a,bを定義
    String a;
    int b;
    @Override
    protected void export() {
        $.<VerticalLayout>create(()->{
            layout(match_parent);
        }).render(()->{
            $.<TextView>create(()->{
                layout(match_parent,0,50);
                text(a);
                textSize(b);
            });
        });
    }
}
```

#### SampleActivity.java
```java
public class SampleActivity extends ForemActivity{
    @Override
    public void render(Root root) {
        $.<SampleComponent>export(args->{
            args.a = "sample";
            args.b = 30;
        });
    }
}
```

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
<h3 id="Component">Component</h3>

`Component`はコンポーネントベースで開発を行うためのクラスです。  
従来のAndroidStudioでは、Fragmentクラスが似た役割を果たしていました。  
以下のサンプルコードを実行すると、テキストが"sample",テキストサイズが30のTextViewが描画されます。
#### サンプルコード
#### SampleComponent.java
```java
public class SampleComponent extends Component {
    // 引数a,bを定義
    String a;
    int b;
    @Override
    protected void export() {
        $.<VerticalLayout>create(()->{
            layout(match_parent);
        }).render(()->{
            $.<TextView>create(()->{
                layout(match_parent,0,50);
                text(a);
                textSize(b);
            });
        });
    }
}
```

#### SampleActivity.java
```java
public class SampleActivity extends ForemActivity{
    @Override
    public void render(Root root) {
        $.<SampleComponent>export(args->{
            args.a = "sample";
            args.b = 30;
        });
    }
}
```

<h3 id="ListLayout">ListLayout</h3>

`ListLayout`はリスト描画を簡素化するためのクラスです。  
従来のAndroid Studioでは、RecyclerViewが同じ役割を持っていましたが、手間が多い点が問題でした。  
以下のサンプルコードを実行すると、テキストが"a0", "b1", "c2", "d3", "e4", テキストサイズが30のTextViewが描画されます。  
```java
var list=new ForemList<String>();
list.add("a");
list.add("b");
list.add("c");
list.add("d");
list.add("e");
$.<ListLayout>create(()->{
    layout(match_parent,match_parent);
    // elemにlistの要素が一つずつ格納される
    // iは繰り返し回数が格納される
    listRender(list,(elem,i)->{
        $.<TextView>create(()->{
            layout(match_parent,100);
            text(elem+i);
            textSize(30);
        });
    });
});
```
