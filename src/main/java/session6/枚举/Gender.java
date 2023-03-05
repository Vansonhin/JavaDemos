package session6.枚举;

public enum Gender implements GenderDesc {
    MALE("男") {
        @Override
        public void info() {
            System.out.println("我是男的哦");
        }
    }, FEMALE("女") {
        @Override
        public void info() {
            System.out.println("我是女的哦");
        }
    };
    private final String name;

    private Gender(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}
