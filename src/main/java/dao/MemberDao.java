package dao;

import entity.Member;

import java.util.List;
import java.util.Map;

public class MemberDao implements BaseDao<Member> {

    private static Map<Long, Member> records;

    @Override
    public List<Member> findAll() {
        return null;
    }

    @Override
    public Member save(Member item) {
        if(item!=null) {
        }
        return null;
    }

    @Override
    public Member findById(Long id) {
        return records.get(id);
    }

    @Override
    public Member update(Member item) {
        return null;
    }

    @Override
    public void delete(Member item) {

    }
}
