# FortniteMobileTloos
> ✨ An LSPosed module for unlocking Fortnite Mobile graphics & frame rate by CPU model spoofing
> 一款通过伪装 CPU 型号解锁堡垒之夜手游画质与帧率的 LSPosed 模块

## 📖 项目介绍
**FortniteMobileTloos** 是专门为 Fortnite Mobile 开发的 LSPosed 模块。

堡垒之夜移动端会读取设备 `hardware`、`processor` 等硬件信息，根据 CPU 型号做白名单判定，**非高端芯片机型会被强制锁帧、限制画质选项**，即便手机硬件性能足够，也无法开启高帧率与高清画面。

本模块使用 LSPosed Hook，在游戏读取硬件信息的时候，**将本机 CPU 型号伪装为 SM8750（骁龙 8 Elite）**，欺骗游戏设备检测逻辑，绕过官方硬件校验，从而解锁游戏隐藏的高帧率、高画质参数。

> 核心原理代码片段
> ```smali
> const-string v1, "hardware"
> const-string v11, "SM8750"
> invoke-interface {v14, v1, v11}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
>
> const-string v1, "processor"
> invoke-interface {v14, v1, v5}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
> ```
> Hook 替换 `hardware` 与 `processor` 字段的值，上报高端 SOC 型号，骗过游戏硬件判断。

## ✨ 功能特性
- **🧠 CPU 型号伪装**：修改 `hardware` / `processor` 硬件标识，伪装为 SM8750
- **🎮 解锁帧率限制**：解除游戏原生帧率锁，开放游戏内更高帧率档位
- **🖼️ 解锁画质选项**：解锁游戏隐藏高清纹理、光影、渲染相关画质设置
- **⚡ 纯 LSP Hook 实现**：不需要修改游戏安装包，不篡改游戏内部核心逻辑
- **🔧 配置灵活**：仅替换硬件识别字段，不改动系统底层其他硬件信息

## 📋 使用前提
1. 设备已获取 Root 权限
2. 已安装 **LSPosed（LSP）** 框架
3. 选择 **Fortnite Mobile** 作为作用域，**勾选目标游戏包名**
4. 重启作用域或者重启手机激活模块

## 📝 使用步骤
1. 下载本模块并安装
2. 打开 LSPosed，启用 `FortniteMobileTloos`
3. 在模块作用域里面勾选 **堡垒之夜手游**
4. 保存配置，重启手机 / 重启游戏进程
5. 进入 Fortnite Mobile 设置页面，即可看到已解锁的帧率、画质选项

## ⚠️ 重要免责声明
> **中文**
> 本项目仅用于技术研究与学习，仅在本地修改应用读取到的硬件返回信息。
> 本项目不提供任何游戏作弊功能，不对使用本模块产生的账号封禁、游戏异常等问题负责。
> 请仔细阅读并遵守游戏用户协议，自行评估使用风险。
>
> **English**
> This project is for **educational & research purposes only**.
> It only spoofs hardware information returned to the game locally.
> No cheating features are included.
> We are **not responsible** for any account ban or game abnormality caused by using this module.
> Use at your own risk and comply with the game EULA.

## 📄 License
- **LICENSE**：正式协议（英文，具备法律效力）
- **LICENSE_ZH.md**：中文翻译，仅供阅读参考

MIT License with Non‑Commercial Addendum

This project is for **non‑commercial use only**.
You may use, modify and distribute for personal study.
Commercial use, sale or monetization is strictly prohibited.

本项目仅限非商业用途。
允许个人学习、修改、分发，严禁商用、售卖盈利。
