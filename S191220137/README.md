# W02

## 任务一

1. 用plantuml画出example的类图与Scene中main方法执行过程中的对象时序图:

    + 类图如下：
![类图](http://www.plantuml.com/plantuml/png/ZLJTRjiy3BtNK-ZI1TGtA89-1Tn-1OQcID9imB0B9MOpOOfaI7AtpkkxJp-COdR6i5vKr25vU4JIkVP1kZ0SDMDxBRtd7vI1aJ4U_nwjLq5Py_aBxz7qsPE36cN2HRwzMDNnVWXDXELEWwWU1FW1mZdywchv0iwf3XOBlWvEcGCFjXWDoOk5W_tFEVaQSVQ64gkkaP4YkfnK-qbJuVKGy7x6A-qTm4zmI3hw88FQlo7AmrSeLlQkhGiHzFcOJuXFtfnoy5NaafiMzHIgfXp5XJs9xu6dFWc5APwc8Ps7HorDKw098_o0_H007QLhoaJgPxa7r3soSxosiakZYQoWuGWc-Ac-6DyGKV5PgJ2PnysmYvqat8LHycbg7_FOdnlmNeQSrlyk-mIB-UMX6gbpHZ1f1Sv_P6GQTMrEnWNPfio6DjQCZ0dTIZq05W4p7FcT7Lo7xCk7Lcm-BiNc_rNRYjlbqqhStczRiRx_9DRjjdt8KSzHaSvyJXp4ZXRkqIY4cHmRWyqXEvZzILOsRbvNqdnhQbWkaP1__HvfoDzxHMFd6qS7NF4iTeQ4jZXrUBfn_FBorm8t-xt3uZV7CdM9nC5No2O4MFetpQZAQmH5a8M0cPAnQp1T_aLblm40 "类图")

    + 时序图如下：
![时序图](http://www.plantuml.com/plantuml/png/dPB1QW8n48RlUOhWNXAmUotieOXWlHGjrLPAwM5rHmrDip8xmUhJrsHdoPRI5dgI-VBFDoQpeuPA9FzkXIWtLAEaFKm1pe0o6zjoyyQugP42k_TuiC3G6WSoM-qDTMHQUwnazWpMriSkLUzazW0LbqSqrDez271aw2GH6cyffm-IsHnBjmCXelpg9PiYW7kzQOSL3exopZXGrrh4OHmvTOaV-WwUr7ms6IvNys6UvyF5v6aoqqAaw_PQ4YnsGCkkKbhmC_IoJE8V6_lrsi8Ya13-cZxrnN_ERO3OqqeqFyX_NA7nyQ32ZqxXf8eRAX38evEbgwHnXanfpHd2aH2yifwT2TzwkmM4QXMP2kZMME1oa7Oxq5fSV6amQtf-vgb75l5GNVhqzno3OcjzirU_13QsRY2iP0IkYb_x9m00 "时序图")

2. 尝试从面向对象编程角度理解`example`的设计理念，具体阐述这样写的好处与可改进之处（越详细越好）:

    + 好处：
        + 通过将排序所需的内容、位置、排序调度者、排序方法等抽象为对象，使整个排序过程中每一步在做什么、需要调用哪些元素清晰可见，便于直观理解排序的实现方法；
        + 同时接口的采用使得在调用相关内容时，只需了解有哪些函数方法可供使用，而不需操心内部的实现逻辑，简化了思维上的要求，便于实现以及替换成不同的方法；

    + 可改进之处：
        + 可以考虑在定义时，将类中的属性实现在一起，将类中的方法实现在一起，两者之间隔开，便于阅读代码；
        + 同时属性尽量按在方法中调用的先后顺序来排序，这样不至于在看到类中方法时不知道这里面调用的属性是什么;
        + 此外，在`Line.get()`方法的定义中，用
            ```java
            if ((i < 0) || (i > positions.length))
            ```
            来判断下标是否越界，但是实际上应该为`i >= positions.length`，该处的边界条件判断不准确（只不过这个函数其实并没有被调用）；

## 任务二

（在任务二和任务三当中，均采用通过向`main`中传入参数来选择调用`Line/Matrix`以及`QuickSort/HeapSort`）

类图如下所示：
![类图](http://www.plantuml.com/plantuml/png/jLN1RjGm4BtxAtnCfVGFgbLL8PK34eMsN107Rp9DpRfsi2SjiFJViSUncs5NaG1r3udzPkRDcnd7UnvGUPmUZ12TKI78Tzh2NWWPVrSkQDJEVluYntaPo49EZRPuGhj7ftivJjX4M6qDjDKo0t80V74_Etl_2Dxh7ZORUOrUsq6Youk6nSN4w5J4n7EHLpJj1KjWyflhBdeoPm2SzozufRq4-0b-9jq7LAYxvncLU0zvHTPhvp62WLx70sAvDoLchgXkQiC2OAPgyejCfH-n7hWTar1OucaIoWUuCies6LemmdVe9eHgIELf6wdlL0Uacqgi_iQfFeqbieA11x0OblgYVyD4nR9IOZQFYsaREycuCwEIoz0nnec3wH_8KClyJsfCS7lyu72DtBWc-CEakrtIozN-izXrLRJ_LbAMm5IItCAWBQt0zYT5IvelqkbTSLvhqdeVQXlUWXeFko1Vimsg_pe5VEEUx8sx7LbvEteQi0FU_rzrzRoNgs4ls2TNxuQooBnbHsJ5fGubeP-KcO2Tf4it-Nwclul93BdwTcYtDT0hk-C9ndb1SPcZbDZMKgifPQR5nO-FaUflBb7kibe_zrrhHXrBnKdT8Gbl6urcULN8qzDV6vdNVngSd6_RygaoVuOpztAakNU5kJF99hzoK2ha4W8YFPOHfUBgmP3Ama2Y5E8SR4z_iU8t "类图")

+ 在终端中输入
```bash
javac S191220137/Scene.java
java S191220137/Scene Line 1
```
选择调用`Line`以及`QuickSort`，程序运行结果请见 https://www.bilibili.com/video/BV1P64y187Uo?share_source=copy_web

+ 类似的，在终端中输入
```bash
javac S191220137/Scene.java
java S191220137/Scene Line 2
```
选择调用`Line`以及`HeapSort`，程序运行结果请见 https://www.bilibili.com/video/BV17q4y1o7YS?share_source=copy_web

## 任务三

类图如下所示：
![类图](http://www.plantuml.com/plantuml/png/nLR1RXCn4BtxAtnSfFGFggYgaCe1HA4j5yJ1oKwt9bjxiMVRGkY_OtkyqnrIBGA4o25hFxzvysRiTN8IqGGSRtkbjhs9KR-s3lPAwVGvzz6YzUxZ9ptKOQILJ6gimnTbTkTjguSHcmIRJGyhNgc0xW2VwCV7R-yW1Dl2UgqlC5ZNQVGqQ4HSIepU94mzJlRUcCHx-AL1elqNY-nghqI2dfxI-UI7D2DWdJF-97i6y0r25Tr7D6YtZnNLU0CqAgiNFc02Otay6v3BlPnYQaKyuOP5G99gw45Br8PS3rmDsIZCyRmN9aGuxurh29efmWDiHmHUoELPbwIlpHR8TowH-RqtRTwMf0ezt8B3EFUN-8qmbShAYSL-d8wRr4cXJOf6pqE75ASETl_0XfddlpT3XbVF7npfKIuk6Nutskqk-vLk_zJiiYkQVvbIJe6v9Bs1pheo0jSIEqy64v1Exp9veKaBVU0sl08p77P1_yiscFRp6F6bltUN_ceGvUtATm-kmvk_guxF-tGrx9LuvVXkc0QaEyso65DuKpBwmVGZY9DqviVGLldhbAmlrB3gLXiE3CRjP8AX3aeSQKmbhhXKNigPo-3qw_iazLkNgA0iro-v2ytWRM6yk3iK4MsZhPbV5VhewFjQq_Zd1LylIrLVLSaNkA1FHrgo6PRaOfjuzQ0mv3CodzBldSheN8BWESADOn61K830EBa0IsgbJi2rvS-3-W40 "类图")

+ 在终端中输入
```bash
javac S191220137/Scene.java
java S191220137/Scene Matrix 1
```
选择调用`Matrix`以及`QuickSort`，程序运行结果请见 https://www.bilibili.com/video/BV1x64y187mg?share_source=copy_web

+ 类似的，在终端中输入
```bash
javac S191220137/Scene.java
java S191220137/Scene Matrix 2
```
选择调用`Matrix`以及`HeapSort`，程序运行结果请见 https://www.bilibili.com/video/BV1Gf4y1E7r7?share_source=copy_web