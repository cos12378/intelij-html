package dto;

public class TodoJoinuser {
    private Integer id;
    private String content;

    public Integer getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public String getCreateAt() {
        return createAt;
    }

    public boolean isChecked() {
        return checked;
    }

    private String createAt;
    private boolean checked;
    private String name;
    private Integer uid;

    public String getName() {
        return name;
    }

    public Integer getUid() {
        return uid;
    }

    public TodoJoinuser(int id, String name, String createAt, boolean checked) {
        this.name = name;
        this.uid = uid;
    }

    public void setTodos(String todos) {
        this.content = content;
    }
}
