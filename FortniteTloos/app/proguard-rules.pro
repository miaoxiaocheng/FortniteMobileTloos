# 忽略 libxposed 注解的警告
-dontwarn io.github.libxposed.annotation.**

# 让混淆工具在重写 java_init.list 时同步更新类名（如果开启了混淆）
-adaptresourcefilecontents META-INF/xposed/java_init.list

# 保留所有继承 XposedModule 的类及其构造函数（通用规则，会涵盖你的 MainModule）
-keep,allowobfuscation,allowoptimization public class * extends io.github.libxposed.api.XposedModule {
    public <init>();
}

# 保留 Hooker 接口实现类（如果你使用了注解方式）
-keep,allowobfuscation,allowoptimization class * implements io.github.libxposed.api.XposedInterface$Hooker