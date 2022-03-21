package hellojpa;

import javax.persistence.*;
import java.util.List;

public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();

        tx.begin();
            try {
                /*Member findmember = em.find(Member.class, 1L);
                findmember.setName("HelloJPA");*/
/*

                List<Member> result = em.createQuery("select m from Member as m", Member.class)
                                .setFirstResult(0)
                                .setMaxResults(2)
                                .getResultList();
                for (Member member : result) {
                    System.out.println("member.name="+member.getName());
                }
*/
/*

                //비영속
                Member member = new Member();
                member.setId(101L);
                member.setName("HelloJPA");

                //영속
                em.persist(member);

                Member findMember = em.find(Member.class, 101L);

                System.out.println("findMember.id = " +findMember.getId());
                System.out.println("findMember.name = " +findMember.getName());

*/
//                Member member1 = new Member(150L,"A");
//                Member member2 = new Member(160L,"B");

               /* em.persist(member1);
                em.persist(member2);
*/
                // 플러시는 영속성 컨테스트에 있는 걸 db로 동기화 시켜준다. //em.flush();
/*

                   Member member = em.find(Member.class , 150L);
                member.setName("zzzz");
*/

                Member member = new Member();
                member.setId(3L);
                member.setUsername("C");
                member.setRoleType(RoleType.GUEST);

                em.persist(member);


                tx.commit();
            }catch (Exception e){
                tx.rollback();
            }finally {
                em.close();
            }
        emf.close();
    }
}
