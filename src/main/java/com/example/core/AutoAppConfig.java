package com.example.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(
        basePackages = "com.example.core.member",
        basePackageClasses = AutoAppConfig.class,
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class))
// basePackages 지정하지 않을 시(default) : @ComponentScan을 붙인 클래스부터 시작하여 하위 패키지를 뒤진다.
// 패키지 위치를 지정하지 안고, 설정 정보 클래스의 위치를 프로젝트 최상단에 두는 것을 권장한다.
public class AutoAppConfig {
}
