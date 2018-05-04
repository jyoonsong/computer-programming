package lab8;
public class Foo {

    public static void main(String[] args) {
        Foo f = new Foo();
        System.out.println( f.toString() );
        Bar f1 = new Bar();
        f1.foo2();
        Foo f2 = new Baz();
        f2.foo1();
        Foo f3 = new Mumble();
        f3.foo2();
    }

    public void foo1() {
        System.out.println("foo 1");
    }

    public void foo2() {
        System.out.println("foo 2");
    }

    @Override
    public String toString() {
        return "foo";
    }
}

class Bar extends Foo {
    @Override
    public void foo2() {
        System.out.println("bar 2");
    }
}

class Baz extends Foo {
    @Override
    public void foo1() {
        System.out.println("baz 1");
    }
    @Override
    public String toString() {
        return "baz";
    }
}

class Mumble extends Baz {
    @Override
    public void foo2() {
        System.out.println("mumble 2");
    }
}
