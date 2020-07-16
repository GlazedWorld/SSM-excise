package com.hehe.dao;

import com.hehe.domain.Member;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface MemberDao {
    @Transactional(readOnly = true)
    @Select("select * from member where id = #{id}")
    Member findById(String id);
}
