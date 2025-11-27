package com.example.umc9th.global.annotation;

// 사용자 정의 어노테이션을 만들 때 사용
@Documented
// validation을 커스텀 어노테이션을 통해 할 수 있는 할 수 있도록 제공
// FoodExistValidator라는 클래스를 통해 @ExistFoods가 붙은 대상을 검증
@Constraint(validatedBy = FoodExistValidator.class)
// 어노테이션의 적용 범위 적용(ElementType 메소드에 필드에 파라미터에 가능)
@Target( { ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER })
// 어노테이션의 생명 주기 지정 (런타임 동안 유호)
@Retention(RetentionPolicy.RUNTIME)
public @interface ExistFoods {
    //여기서 디폴트 메시지를 설정합니다.
    String message() default "해당 음식이 존재하지 않습니다.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
