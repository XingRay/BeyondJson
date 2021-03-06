# BeyondJson
BeyondJson

实现目标：
1. 反序列化对象的对象不使用包装类，而是使用基本数据类型+flag形式， 判断基本数据类型的字段是否存在将通过hasXxx()方法来进行判断，而不再通过获取包装类对象再通过判空进行。目的：减少包装类对象的内存开销
对象类的代码的可以通过插件实现，不需要手动编写

如：

````json

{"name":"alex", "age":18, "isVip":false}

````

对应的对象为

```java

public class Customer {
    private static final int FLAG_AGE_MARK = 1;
    private static final int FLAG_IS_VIP_MARK = 2;

    private int flag;
    private String name;
    private int age;
    private boolean isVip;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean hasAge() {
        return (flag & FLAG_AGE_MARK) != 0;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
        flag |= FLAG_AGE_MARK;
    }

    public boolean hasIsVip() {
        return (flag & FLAG_IS_VIP_MARK) != 0;
    }

    public boolean isVip() {
        return isVip;
    }

    public void setVip(boolean vip) {
        isVip = vip;
        flag |= FLAG_IS_VIP_MARK;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "flag=" + flag +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", isVip=" + isVip +
                '}';
    }
}

```

2. json中的对象的数组不使用json中的数组，而是将该对象的字段变成数组。目的：减少json长度，降低网络流量开销及提高传输速度。
如：原始版本json表示的Customer数组为：

```json

[
    {"name":"alex", "age":18, "isVip":false},
    {"name":"bob", "age":19, "isVip":true},
    {"name":"coco", "age":20, "isVip":false}
]


```


则将通过以下形式表示：

```json

{
    "name":["alex", "bob","coco"], 
    "age":[18, 19, 20], 
    "isVip":[false, true, false]
}

```
