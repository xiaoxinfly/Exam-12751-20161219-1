package com.exam1.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.exam1.pojo.Film;
import com.exam1.pojo.Language;
import com.exam1.service.IFilmService;
import com.exam1.service.ILanguageService;
import com.exam1.service.impl.FilmServiceImpl;
import com.exam1.service.impl.LanguageServiceImpl;
import com.exam1.util.PageUtil;
import com.exam1.util.ServletUtil;

@WebServlet("/FilmServlet")
public class FilmServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private IFilmService iFilmService;
	private ILanguageService ilLanguageService;

	private HttpServletRequest request;
	private HttpServletResponse response;
	private HttpSession session;

	public FilmServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.request = request;
		this.response = response;
		this.request.setCharacterEncoding("utf-8");
		this.response.setContentType("text/html;charset=utf-8");
		String code = this.request.getParameter("code");
		switch (Integer.valueOf(code)) {
		case ServletUtil.FILM_ADD:
			addFilm();
			break;
		case ServletUtil.FILM_DELETE:
			deleteFilm();
			break;
		case ServletUtil.FILM_UPDATE:
			updateFilm();
			break;
		case ServletUtil.FILM_SELECT:
			selectFilm();
			break;
		case ServletUtil.FILM_SUM:
			updateSUM();
			break;
		default:
			break;
		}
	}

	private void updateSUM() {
		PageUtil pageUtil = (PageUtil) session.getAttribute("pageUtil");
		String num = this.request.getParameter("num");
		pageUtil.setSum(Integer.valueOf(num));
		session.setAttribute("pageUtil", pageUtil);
	}

	private void selectFilm() throws IOException {
		session = this.request.getSession();
		String page = this.request.getParameter("page");
		PageUtil pageUtil = (PageUtil) session.getAttribute("pageUtil");
		String num = null;
		if (pageUtil == null) {
			pageUtil = new PageUtil();
			num = this.request.getParameter("num");
			pageUtil.setSum(Integer.valueOf(num));
		}
		int count = this.iFilmService.getCount();
		pageUtil.setPage(Integer.valueOf(page));
		pageUtil.setCount(count);
		pageUtil.setSum(pageUtil.getSum());
		List<Film> filmList = this.iFilmService.getFilmByPage(pageUtil.getPage(), pageUtil.getSum());
		session.setAttribute("filmList", filmList);
		session.setAttribute("pageUtil", pageUtil);
		this.response.sendRedirect("film.jsp");
	}

	@SuppressWarnings("unchecked")
	private void updateFilm() throws IOException, ServletException {
		String edit = this.request.getParameter("edit");
		String filmId = this.request.getParameter("flim_id");
		Object object = this.session.getAttribute("filmList");
		switch (Integer.valueOf(edit)) {
		case 1:
			if (object instanceof List) {
				List<Film> filmList = (List<Film>) object;
				for (Film film : filmList) {
					if (film.getFilmId().equals(Short.valueOf(filmId))) {
						List<Language> languageList = ilLanguageService.getLanguageList();
						this.request.setAttribute("editFilm", film);
						this.request.setAttribute("languageList", languageList);
						this.request.getRequestDispatcher("film/update.jsp").forward(this.request, this.response);
						break;
					}
				}
			}
			break;
		case 2:
			if (object instanceof List) {
				String title = this.request.getParameter("title");
				String description = this.request.getParameter("description");
				String languageId = this.request.getParameter("language_id");
				Film film = new Film();
				film.setTitle(title);
				film.setDescription(description);
				film.setLanguageId(Byte.valueOf(languageId));
				film.setFilmId(Short.valueOf(filmId));
				if (this.iFilmService.updateFilmById(film)) {
					success();
				} else {
					fail();
				}
			}
			break;

		default:
			break;
		}
	}

	private void fail() throws IOException {
		this.response.getWriter().append("fail");
		this.response.getWriter().append("<a href=\"index.jsp\">返回首页</a><br />");
		this.response.getWriter().append("<a href=\"film.action?code=4&page=1&num=10\">查看电影</a><br />");

	}

	private void success() throws IOException {
		this.response.getWriter().append("success<br />");
		this.response.getWriter().append("<a href=\"index.jsp\">返回首页</a><br />");
		this.response.getWriter().append("<a href=\"film.action?code=4&page=1&num=10\">查看电影</a><br />");
	}

	private void deleteFilm() throws IOException {
		String filmId = this.request.getParameter("flim_id");
		if (this.iFilmService.deleteFilmById(Integer.valueOf(filmId))) {
			this.response.getWriter().println("success");
		} else {
			this.response.getWriter().println("fail");
		}
	}

	private void addFilm() throws IOException, ServletException {
		String edit = this.request.getParameter("edit");
		switch (Integer.valueOf(edit)) {
		case 1:
			List<Language> languageList = ilLanguageService.getLanguageList();
			this.request.setAttribute("languageList", languageList);
			this.request.getRequestDispatcher("film/add.jsp").forward(this.request, this.response);
			break;
		case 2:
			String title = this.request.getParameter("title");
			String description = this.request.getParameter("description");
			String languageId = this.request.getParameter("language_id");
			Film film = new Film();
			film.setTitle(title);
			film.setDescription(description);
			film.setLanguageId(Byte.valueOf(languageId));
			if (this.iFilmService.addFilm(film)) {
				success();
			} else {
				fail();
			}
			break;

		default:
			break;
		}
	}

	@Override
	public void init() throws ServletException {
		super.init();
		iFilmService = new FilmServiceImpl();
		ilLanguageService = new LanguageServiceImpl();
	}

}
