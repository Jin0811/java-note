package generic;

/*
  ===== 泛型接口（Generic Interface）=====

  泛型也能用在接口上：接口里先用 <T> 占位，实现类再决定 T 是谁。
  这是后端 DAO / Repository 层的标准模式（本 demo 就是真实业务的缩影）。

  类比 TS：
    TS:    interface Repository<T> { findById(id: number): T }
    Java:  interface Repository<T> { T findById(Long id); }
    实现时 implements Repository<UserEntity>，T 就被定成 UserEntity。

  完整链路（理解的关键）：
    ① interface Repository<T>
         └─ T findById(Long id)          T 是"占位符"，接口不管 T 是谁
    ② class UserRepository implements Repository<UserEntity>
         └─ 实现时把 T「钉死」为 UserEntity   ← 关键动作：泛型参数具体化
         └─ public UserEntity findById(...)  所以实现方法返回 UserEntity
    ③ Repository<UserEntity> userRepository = new UserRepository()
         └─ 左边声明也带 <UserEntity>，和右边实现一致
    ④ UserEntity user = userRepository.findById(1L)
         └─ 编译器看左边 Repository<UserEntity> → findById 返回 T=UserEntity
            类型精确，不用强转

  注意：第④步不是"推断"，而是"泛型代入"——
    T 在 implements Repository<UserEntity> 那一刻就被绑定成 UserEntity，
    编译器照表查 T→UserEntity 即可。真正靠"猜"的推断是 var / new ArrayList<>()。
*/

public class GenericInterfaceDemo {
    public static void main(String[] args) {
        // ③ 声明为接口类型 Repository<UserEntity>，右边是实现类。
        //    面向接口 + 泛型：调用方只依赖 Repository 契约，且知道 T=UserEntity。
        Repository<UserEntity> userRepository = new UserRepository();

        // ④ findById 返回 T=UserEntity，无需强转，编译期类型就确定了。
        UserEntity user = userRepository.findById(1L);

        System.out.println("user.id = " + user.getId());
        System.out.println("user.name = " + user.getName());
    }
}

// ① 泛型接口：T 是占位符，findById 返回"待定类型"。
interface Repository<T> {
    T findById(Long id);
}

// ② 实现类把泛型参数「具体化」为 UserEntity。
//    一旦 implements Repository<UserEntity>，本类里所有 T 都变成了 UserEntity。
class UserRepository implements Repository<UserEntity> {
    public UserEntity findById(Long id) {
        return new UserEntity(id, "Alex");
    }
}

// 数据实体类：对应数据库里的一张 user 表（后端叫 Entity）。
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

