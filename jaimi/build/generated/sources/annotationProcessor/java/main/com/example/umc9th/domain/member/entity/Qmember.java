package com.example.umc9th.domain.member.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.dsl.StringTemplate;

import com.querydsl.core.types.PathMetadata;
import com.querydsl.core.annotations.Generated;
import com.querydsl.core.types.Path;


/**
 * Qmember is a Querydsl query type for member
 */
@SuppressWarnings("this-escape")
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class Qmember extends EntityPathBase<member> {

    private static final long serialVersionUID = -853250304L;

    public static final Qmember member = new Qmember("member1");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath name = createString("name");

    public Qmember(String variable) {
        super(member.class, forVariable(variable));
    }

    public Qmember(Path<? extends member> path) {
        super(path.getType(), path.getMetadata());
    }

    public Qmember(PathMetadata metadata) {
        super(member.class, metadata);
    }

}

