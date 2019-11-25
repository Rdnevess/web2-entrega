package dao;
import entidades.Produto;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

public class ProdutoDAOImpl implements ProdutoDAO{
    
    private EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("ProjetoPU");
    
    public void save( Produto produto){
        EntityManager em = fabrica.createEntityManager();
        em.getTransaction().begin();
        if(produto.getId()>0){
            em.merge(produto);
        }else{
            em.persist(produto);
        }
        em.getTransaction().commit();
        em.close();
    }
    
    public void delete(Produto produto){
        EntityManager em = fabrica.createEntityManager();
        em.getTransaction().begin();
        
        if(!em.contains(produto)){
            produto = em.merge(produto);
        }
        em.remove(produto);
        
        em.getTransaction().commit();
        em.close();
    }
    public Produto find(int id){
        EntityManager em= fabrica.createEntityManager();
        return em.find(Produto.class, id);
    }
    
    public List<Produto> list(){
        EntityManager em = fabrica.createEntityManager();
        Query q = em.createQuery("SELECT c FROM Produto as c ORDER BY c.id");
        return q.getResultList();
        
    }
}
