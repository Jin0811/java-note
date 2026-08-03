package generic;

public class GenericInterfaceDemo {
    public static void main(String[] args) {
        Repository<UserEntity> userRepository = new UserRepository();
        UserEntity user = userRepository.findById(1L);

        System.out.println("user.id = " + user.getId());
        System.out.println("user.name = " + user.getName());
    }
}

interface Repository<T> {
    T findById(Long id);
}

class UserRepository implements Repository<UserEntity> {
    public UserEntity findById(Long id) {
        return new UserEntity(id, "Alex");
    }
}

class UserEntity {
    private Long id;
    private String name;

    UserEntity(Long id, String name) {
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

