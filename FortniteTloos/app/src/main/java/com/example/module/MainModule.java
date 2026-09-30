package com.example.module;

import java.lang.reflect.Method;
import java.util.HashMap;

import io.github.libxposed.api.XposedInterface;
import io.github.libxposed.api.XposedModule;
import io.github.libxposed.api.XposedModuleInterface;

public class MainModule extends XposedModule {

    // 用常量避免运行时创建字符串
    private static final String KEY_HARDWARE = "hardware";
    private static final String VAL_SPOOF = "SM8750";

    public MainModule() {
        super();
    }

    @Override
    public void onPackageLoaded(XposedModuleInterface.PackageLoadedParam param) {
        if (!"com.epicgames.fortnite".equals(param.getPackageName())) {
            return;
        }

        try {
            hookHashMapPut(param.getDefaultClassLoader());
        } catch (Throwable ignored) {}
    }

    private void hookHashMapPut(ClassLoader cl) {
        try {
            Class<?> hashMapClass = cl.loadClass("java.util.HashMap");
            Method put = hashMapClass.getMethod("put", Object.class, Object.class);

            hook(put).intercept(chain -> {
                Object key = chain.getArg(0);

                // 快速路径：不是 hardware，零额外开销
                if (key != KEY_HARDWARE && !KEY_HARDWARE.equals(key)) {
                    return chain.proceed();
                }

                // 不遍历堆栈！改用其他方式判断
                // 方案：检查 this 对象的 hashCode 特征，或完全不做过滤（接受误拦截）
                // 如果 u1() 中只 put 一次 hardware，可以直接全局替换
                Object[] newArgs = new Object[]{key, VAL_SPOOF};
                return chain.proceed(newArgs);
            });
        } catch (Throwable ignored) {}
    }
}

