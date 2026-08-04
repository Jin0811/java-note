package lab.generic;

public class Lab03GenericInterfacePractice {
    public static void main(String[] args) {
        /*
         * 练习目标：泛型接口。
         *
         * TODO:
         * 1. 定义 Store<T> 接口，声明 findById 方法。
         * 2. 创建 CourseStore 实现 Store<CourseEntity>。
         * 3. 通过 Store<CourseEntity> 接口类型接收实现类。
         * 4. 调用 findById，输出课程信息。
         */

        Store<CourseEntity> store = new CourseStore();
        CourseEntity course = store.findById(1L);

        System.out.println(course.getId());
        System.out.println(course.getName());
    }
}

interface Store<T> {
    T findById(Long id);
}

class CourseStore implements Store<CourseEntity> {
    public CourseEntity findById(Long id) {
        return new CourseEntity(id, "Java 后端入门");
    }
}

class CourseEntity {
    private Long id;
    private String name;

    CourseEntity(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
