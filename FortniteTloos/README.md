# Xposed 模块模板 (基于 libxposed)

这是一个通用的 Xposed 模块模板，基于 [libxposed](https://github.com/libxposed/api) 构建。

## 如何使用

1. **修改包名**: 将 `app/build.gradle` 中的 `namespace` 和 `applicationId` 修改为你自己的包名。
2. **重命名包目录**: 将 `app/src/main/java/com/example/module` 目录重命名为匹配你包名的目录结构。
3. **更新模块入口**: 
   - 修改 `MainModule.java` 以实现你的逻辑。
   - 更新 `app/src/main/resources/META-INF/xposed/java_init.list` 里的类名，确保它指向你的 `XposedModule` 实现类。
4. **配置作用域**:
   - 在 `app/src/main/resources/META-INF/xposed/scope.list` 中列出你想要 Hook 的应用包名（每行一个）。
5. **设置编译参数**:
   - 根据需要修改 `app/build.gradle` 中的 `compileSdk` 和 `targetSdkVersion`。

## 主要类介绍

- `MainModule.java`: 模块的主入口，继承自 `XposedModule`。
- `java_init.list`: 告诉 libxposed 模块的入口类是谁。
- `scope.list`: 定义模块生效的作用域（应用）。
- `module.prop`: 模块的元数据信息。

## 注意事项

- 本模板使用了 `libxposed` API，请参考其官方文档以了解更多高级用法。
- 确保在开发过程中正确配置 `compileOnly` 依赖，以避免将 Xposed API 打包进你的 APK。
