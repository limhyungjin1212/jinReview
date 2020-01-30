package com.lhj.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.lhj.model.Criteria;
import com.lhj.model.PageVO;
import com.lhj.model.ReviewVO;
import com.lhj.service.ReviewService;

@RestController
@RequestMapping("replies")
public class ReplyController {

	@Autowired
	private ReviewService rs;

	private static final Logger logger = LoggerFactory.getLogger(ReplyController.class);

	/* 댓글 등록 */
	@RequestMapping(value = "", method = RequestMethod.POST) // post는 등록
	public ResponseEntity<String> register(ReviewVO rv) {
		logger.info("댓글등록으로 오셧나요 ..?");
		logger.info("댓글 등록할 데이터 =" + rv);
		ResponseEntity<String> entity = null;
		try {
			rs.repWrite(rv);
			entity = new ResponseEntity<String>("success", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}

		return entity;
	}

	/* 댓글 목록 */
	@RequestMapping(value = "/all/{pno}", method = RequestMethod.GET)
	public ResponseEntity<List> list(@PathVariable("pno") int pno) {
		logger.info("댓글목록으로 오셧다.");
		logger.info("ReviewVO :" + pno);
		ResponseEntity<List> entity = null;

		try {
			entity = new ResponseEntity<List>(rs.repList(pno), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<List>(HttpStatus.BAD_REQUEST);
		}
		return entity;
	}

	/* 댓글 수정 */
	@RequestMapping(value = "/{rno}", method = { RequestMethod.PUT, RequestMethod.PATCH })
	public ResponseEntity<String> update(@PathVariable("rno") int rno, @RequestBody ReviewVO rv) {

		logger.info("ReviewVO :" + rno);
		ResponseEntity<String> entity = null;

		try {
			rv.setRno(rno);
			rs.repModify(rv);
			entity = new ResponseEntity<String>("success", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}

		return entity;
	}

	/* 댓글 삭제 */
	@RequestMapping(value = "/{rno}", method = RequestMethod.DELETE)
	public ResponseEntity<String> remove(@PathVariable("rno") int rno) {

		logger.info("ReviewVO :" + rno);
		ResponseEntity<String> entity = null;

		try {
			rs.repDel(rno);
			entity = new ResponseEntity<String>("success", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}

		return entity;
	}

	/* 댓글 페이징 목록 */
	@RequestMapping(value = "/{pno}/{page}", method = RequestMethod.GET)
	public ResponseEntity<Map<String, Object>> listPage(@PathVariable("pno") int pno, @PathVariable("page") int page) {

		logger.info("ReplyPage :" + pno + "/" + page);
		ResponseEntity<Map<String, Object>> entity = null;

		try {
			Criteria cri = new Criteria();
			cri.setPageNum(page);

			int cnt = rs.repCount(pno);
			logger.info("cnt=" + cnt);

			PageVO pv = new PageVO(cri, cnt);
			List<ReviewVO> pagelist = rs.repListPage(pno, cri);

			logger.info("pagelist=" + pagelist);

			Map<String, Object> map = new HashMap<String, Object>();
			map.put("list", pagelist);
			map.put("page", pv);

			entity = new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
			logger.info("entity = " + entity);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<Map<String, Object>>(HttpStatus.BAD_REQUEST);
		}
		return entity;
	}

	
	/* 도움이 된 수 증가 */
	@RequestMapping(value = "Helpful/{rno}", method = { RequestMethod.PUT, RequestMethod.PATCH })
	public ResponseEntity<String> updateHelpful(@PathVariable("rno") int rno) {

		logger.info("helpful?? :" + rno);
		ResponseEntity<String> entity = null;

		try {
			rs.HelpfulAdd(rno);
			entity = new ResponseEntity<String>("success", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}

		return entity;
	}
	
	/* 도움이 된 수 증가 */
	@RequestMapping(value = "Helpfuldis/{rno}", method = { RequestMethod.PUT, RequestMethod.PATCH })
	public ResponseEntity<String> updateHelpfuldis(@PathVariable("rno") int rno) {

		logger.info("helpful?? :" + rno);
		ResponseEntity<String> entity = null;

		try {
			rs.Helpfuldis(rno);
			entity = new ResponseEntity<String>("success", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}

		return entity;
	}
}
