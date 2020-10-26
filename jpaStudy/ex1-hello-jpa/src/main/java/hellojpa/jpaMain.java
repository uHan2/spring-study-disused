package hellojpa;

import javax.persistence.*;
import java.util.List;

public class jpaMain
{
    public static void main(String[] args)
    {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try
        {
            Team team = new Team();
            team.setName("TeamA");
            em.persist(team);

            Member member = new Member();
            member.setName("Member1");
            member.setTeam(team);
            em.persist(member);

            em.flush();
            em.clear();

            Member findMember = em.find(Member.class, member.getId());
            List<Member> members = findMember.getTeam().getMembers();

            for(Member m : members)
            {
                System.out.println("m = " + m.getName());
            }

            tx.commit();
        } catch (Exception e)
        {
            tx.rollback();
        } finally
        {
            em.close();
        }

        emf.close();
    }
}
