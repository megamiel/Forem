package forem.java.sample;

import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import forem.java.activitys.ForemActivity;
import forem.java.annotation.Preview;
import forem.java.extensions.ForemList;
import forem.java.ui.ForemListView;
import forem.java.views.HorizontalLayout;
import forem.java.views.Root;
import forem.java.views.VarArea;

public class TodoListSampleActivity extends ForemActivity {
    @Override
    public void render(Root root) {
        onBack = none;
        var todoList = var(new ForemList<String>());
        var todoEditText = varType(EditText.class);
        $.<HorizontalLayout>create(() -> {
            layout(match_parent, 0, 10);
        }).render(() -> {
            $.<EditText>create(todoEditText, () -> {
                layout(0, match_parent, 70);
                hint("タスクを入力");
                textSize(24);
            });
            $.<Button>create(() -> {
                layout(0, match_parent, 30);
                text("追加");
                textSize(24);
                onClick(() -> {
                    var todo = todoEditText[v].getText().toString();
                    if (todo.equals("") || todoList[v].contains(todo)) return;
                    text("aiueo");
                    todoEditText[v].setText("");
                    todoList[v].add(todo);
                    notify(todoList);
                });
            });
        });
        ForemListView.create(() -> {
            layout(match_parent, 0, 90);
        }).render(() -> {
            $.<VarArea>create(() -> {
                layout(match_parent);
                onNotify(todoList, () -> {
                    todoList[v].forEach((todo, i) -> {
                        $.<HorizontalLayout>create(() -> {
                            layout(match_parent, wrap_content);
                        }).render(() -> {
                            $.<TextView>create(() -> {
                                layout(0, match_parent, 70);
                                text(todo);
                                textSize(22);
                            });
                            $.<Button>create(() -> {
                                layout(0, match_parent, 30);
                                text("完了");
                                textSize(22);
                                onClick(() -> {
                                    todoList[v].remove(i);
                                    notify(todoList);
                                });
                            });
                        });
                    });
                });
            });
        });
    }
}