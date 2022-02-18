import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.domain.BoardVO;
import org.zerock.mapper.BoardMapper;
import org.zerock.mapper.BordMapperTests;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class BoardMapperTests {
    private static final Logger log = Logger.getLogger(BordMapperTests.class);
    private BoardMapper mapper;

    public BoardMapperTests() {
    }

    @Test
    public void testGetList() {
        this.mapper.getList().forEach((board) -> {
            log.info(board);
        });
    }

    @Test
    public void testInsert() {
        BoardVO board = new BoardVO();
        board.setTitle("새로 작성하는 글");
        board.setContent("새로 작성하는 내용");
        board.setWriter("newbie");
        this.mapper.insert(board);
        log.info(board);
    }

    @Autowired
    public void setMapper(BoardMapper mapper) {
        this.mapper = mapper;
    }
}

