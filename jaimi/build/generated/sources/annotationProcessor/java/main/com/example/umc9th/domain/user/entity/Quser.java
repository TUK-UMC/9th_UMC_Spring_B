package com.example.umc9th.domain.user.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.dsl.StringTemplate;

import com.querydsl.core.types.PathMetadata;
import com.querydsl.core.annotations.Generated;
import com.querydsl.core.types.Path;


/**
 * Quser is a Querydsl query type for user
 */
@SuppressWarnings("this-escape")
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class Quser extends EntityPathBase<user> {

    private static final long serialVersionUID = -1600878302L;

    public static final Quser user = new Quser("user");

    public final StringPath account = createString("account");

    public final StringPath address = createString("address");

    public final NumberPath<Integer> birth = createNumber("birth", Integer.class);

    public final StringPath gender = createString("gender");

    public final NumberPath<Long> id1 = createNumber("id1", Long.class);

    public final StringPath name = createString("name");

    public final NumberPath<Integer> point = createNumber("point", Integer.class);

    public final StringPath sns = createString("sns");

    public final StringPath sns_name = createString("sns_name");

    public Quser(String variable) {
        super(user.class, forVariable(variable));
    }

    public Quser(Path<? extends user> path) {
        super(path.getType(), path.getMetadata());
    }

    public Quser(PathMetadata metadata) {
        super(user.class, metadata);
    }

}

