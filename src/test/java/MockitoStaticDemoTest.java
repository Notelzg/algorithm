import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import tree.BinaryTreeNode;
import tree.RecursiveInOrderBinaryTree;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MockitoStaticDemoTest {
    MockedStatic<RecursiveInOrderBinaryTree> utilities = Mockito.mockStatic(RecursiveInOrderBinaryTree.class);

    @BeforeEach
    public void setUp()  {
      List<Integer> rs = new ArrayList<>();
      rs.add(1);
      rs.add(2);
      rs.add(200);
      rs.add(20000);
      utilities.when(() -> RecursiveInOrderBinaryTree.inOrder(Mockito.any())).thenReturn(rs);
    }

    @AfterEach
    public void reset() {
      utilities.close();
    }


    @Test
    public void translateOpenId2midIfNeed()  {
      List<Integer> rs1 = RecursiveInOrderBinaryTree.inOrder(new BinaryTreeNode<>(100));
      assertEquals(4, rs1.size());
    }
}
