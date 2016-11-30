package com.etoak.bbs.common.pager;

import java.io.Serializable;
import java.util.List;

/**
 * 
 * @ClassName: Pager 
 * @Description: 分页 工具类 
 * @author 刘林
 * @date 2016年11月25日 上午11:31:35 
 * 
 * @param <T>
 */
public class Pager<T> implements Serializable {
	private static final long serialVersionUID = 1L;
	public static final int DEFAULT_PAGESIZE = 10;
	private List<T> records;
	private int page = 1;
	private int rows = 10;
	private int pageOffset;
	private String sort;
	private String order;
	private int totalPage;//总页数
	private Long totalCount;//总条数
	private int startPageIndex;
	private int endPageIndex;
	private int pageCode = 50;
	private int previewPage = 1;
	private int nextPage = 1;
	private T t;

	public Pager() {
	}

	public Pager(int page, int rows) {
		this.page = page;
		this.rows = rows;
	}

	public Pager(int page) {
		this.page = page;
		this.rows = 10;
	}

	public int getPageOffset() {
		this.pageOffset = ((this.page - 1) * this.rows);
		return this.pageOffset;
	}

	public void setPageOffset(int pageOffset) {
		this.pageOffset = pageOffset;
	}

	public int getPage() {
		return this.page;
	}

	public void setPage(int page) {
		if (page > 0)
			this.page = page;
	}

	public int getRows() {
		return this.rows;
	}

	public void setRows(int rows) {
		if (rows > 0)
			this.rows = rows;
	}

	public String getSort() {
		return this.sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}

	public String getOrder() {
		return this.order;
	}

	public void setOrder(String order) {
		this.order = order;
	}

	public int getTotalPage() {
		return this.totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;

		this.startPageIndex = (this.page - ((this.pageCode % 2 == 0) ? this.pageCode / 2 - 1
				: this.pageCode / 2));

		this.endPageIndex = (this.page + this.pageCode / 2);
		if (this.startPageIndex < 1) {
			this.startPageIndex = 1;
			if (totalPage >= this.pageCode)
				this.endPageIndex = this.pageCode;
			else {
				this.endPageIndex = totalPage;
			}
		}
		if (this.endPageIndex > totalPage) {
			this.endPageIndex = totalPage;
			if (this.endPageIndex - this.pageCode > 0)
				this.startPageIndex = (this.endPageIndex - this.pageCode + 1);
			else {
				this.startPageIndex = 1;
			}
		}
		this.previewPage = (this.page - 1);
		this.nextPage = (this.page + 1);
		if (this.page <= 1) {
			this.previewPage = 1;
		}
		if (this.page >= this.totalPage) {
			this.nextPage = this.totalPage;
		}
		if (this.totalPage == 0)
			this.startPageIndex = 0;
	}

	public Long getTotalCount() {
		return this.totalCount;
	}

	public void setTotalCount(Long totalCount) {
		this.totalCount = totalCount;
		setTotalPage((int) ((totalCount.longValue() % this.rows == 0L) ? totalCount
				.longValue() / this.rows
				: totalCount.longValue() / this.rows + 1L));
	}

	public int getStartPageIndex() {
		return this.startPageIndex;
	}

	public void setStartPageIndex(int startPageIndex) {
		this.startPageIndex = startPageIndex;
	}

	public int getEndPageIndex() {
		if (this.endPageIndex < this.startPageIndex) {
			this.endPageIndex = this.startPageIndex;
		}
		return this.endPageIndex;
	}

	public void setEndPageIndex(int endPageIndex) {
		this.endPageIndex = endPageIndex;
	}

	public int getPageCode() {
		return this.pageCode;
	}

	public void setPageCode(int pageCode) {
		this.pageCode = pageCode;
	}

	public int getPreviewPage() {
		return this.previewPage;
	}

	public void setPreviewPage(int previewPage) {
		this.previewPage = previewPage;
	}

	public int getNextPage() {
		return this.nextPage;
	}

	public void setNextPage(int nextPage) {
		this.nextPage = nextPage;
	}

	public List<T> getRecords() {
		return this.records;
	}

	public void setRecords(List<T> records) {
		this.records = records;
	}

	public T getT() {
		return this.t;
	}

	public void setT(T t) {
		this.t = t;
	}
}