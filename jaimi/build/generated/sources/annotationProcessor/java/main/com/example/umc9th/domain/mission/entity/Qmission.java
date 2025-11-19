package com.example.umc9th.domain.mission.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.dsl.StringTemplate;

import com.querydsl.core.types.PathMetadata;
import com.querydsl.core.annotations.Generated;
import com.querydsl.core.types.Path;


/**
 * Qmission is a Querydsl query type for mission
 */
@SuppressWarnings("this-escape")
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class Qmission extends EntityPathBase<mission> {

    private static final long serialVersionUID = -1218879566L;

    public static final Qmission mission = new Qmission("mission");

    public final NumberPath<Long> id1 = createNumber("id1", Long.class);

    public final NumberPath<Long> id2 = createNumber("id2", Long.class);

    public final StringPath mission_award = createString("mission_award");

    public final StringPath mission_explain = createString("mission_explain");

    public final NumberPath<Integer> mission_progress = createNumber("mission_progress", Integer.class);

    public final NumberPath<Integer> mission_start = createNumber("mission_start", Integer.class);

    public final StringPath mission_success = createString("mission_success");

    public final NumberPath<Integer> mission_time = createNumber("mission_time", Integer.class);

    public Qmission(String variable) {
        super(mission.class, forVariable(variable));
    }

    public Qmission(Path<? extends mission> path) {
        super(path.getType(), path.getMetadata());
    }

    public Qmission(PathMetadata metadata) {
        super(mission.class, metadata);
    }

}

