package forem.java.sample;

import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import forem.java.activitys.ForemActivity;
import forem.java.extensions.ForemList;
import forem.java.ui.ForemListView;
import forem.java.views.HorizontalLayout;
import forem.java.views.Root;

public class TodoListSampleActivity extends ForemActivity {
    @Override
    public void render(Root root) {
        var todoList = var(new ForemList<String>());
        var taskEditText = varType(EditText.class);
        space(match_parent, 0, 1);
        this.<HorizontalLayout>create(() -> {
            layout(match_parent, 0, 10);
        }).render(() -> {
            this.<EditText>create(taskEditText, () -> {
                layout(0, match_parent, 70);
                hint("タスクを入力");
                textSize(24);
            });
            this.<Button>create(() -> {
                layout(0, match_parent, 30);
                text("追加");
                textSize(24);
                onClick(() -> {
                    var taskName = get(taskEditText).getText().toString();
                    if (taskName.equals(""))
                        return;
                    get(taskEditText).setText("");
                    get(todoList).add(taskName);
//                    ignite(todoList);
                });
            });
        });
        ForemListView.create(() -> {
            layout(match_parent, 0, 89);
        }).render(() -> {
//            onChange(todoList, () -> {
//                clearChild();
//                get(todoList).forEach((todo, index) -> {
//                    this.<HorizontalLayout>create(() -> {
//                        layout(match_parent, wrap_content);
//                    }).render(() -> {
//                        this.<TextView>create(() -> {
//                            layout(0, match_parent, 60);
//                            text(todo);
//                            textSize(26);
//                        });
//                        this.<Button>create(() -> {
//                            layout(0, match_parent, 40);
//                            text("完了");
//                            textSize(18);
//                            onClick(() -> {
//                                get(todoList).remove(index);
//                                ignite(todoList);
//                            });
//                        });
//                    });
//                });
//            });
        });
    }
}
