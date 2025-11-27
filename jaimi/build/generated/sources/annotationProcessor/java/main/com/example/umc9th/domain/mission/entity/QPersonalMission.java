package com.example.umc9th.domain.mission.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.dsl.StringTemplate;

import com.querydsl.core.types.PathMetadata;
import com.querydsl.core.annotations.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QPersonalMission is a Querydsl query type for PersonalMission
 */
@SuppressWarnings("this-escape")
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QPersonalMission extends EntityPathBase<PersonalMission> {

    private static final long serialVersionUID = -1629914318L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QPersonalMission personalMission = new QPersonalMission("personalMission");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final Qmission mission;

    public final NumberPath<Integer> time = createNumber("time", Integer.class);

    public final com.example.umc9th.domain.user.entity.Quser user;

    public QPersonalMission(String variable) {
        this(PersonalMission.class, forVariable(variable), INITS);
    }

    public QPersonalMission(Path<? extends PersonalMission> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QPersonalMission(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QPersonalMission(PathMetadata metadata, PathInits inits) {
        this(PersonalMission.class, metadata, inits);
    }

    public QPersonalMission(Class<? extends PersonalMission> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.mission = inits.isInitialized("mission") ? new Qmission(forProperty("mission")) : null;
        this.user = inits.isInitialized("user") ? new com.example.umc9th.domain.user.entity.Quser(forProperty("user")) : null;
    }

}

