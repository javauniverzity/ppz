package com.ppz.web.spring.controller;

import java.math.BigDecimal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ppz.web.entity.Avatar;
import com.ppz.web.entity.FinancialAssets;
import com.ppz.web.entity.Game;
import com.ppz.web.entity.GameCode;
import com.ppz.web.interfaces.service.PpzService;
import com.ppz.web.interfaces.service.UserService;
import com.ppz.web.utils.Enums;
import com.ppz.web.utils.WebUtils;

/**
 * Stranka PPZ.
 *
 * @author Honza
 */

@Controller
public class BankController {

	/** Konstanta ACTION. */
	public static final String ACTION = "bank";

	/** Konstanta ACTION_ADD. */
	public static final String ACTION_ADD = "bankAdd";

	/** Konstanta ACTION_REMOVE. */
	public static final String ACTION_REMOVE = "bankRemove";

	/** Konstanta REDIRECT. */
	public static final String REDIRECT = "redirect:" + ACTION + ".html";

	/** The user service. */
	@Autowired
	UserService userService;

	/** The ppz service. */
	@Autowired
	PpzService ppzService;

	/** The logger. */
	Logger logger = Logger.getLogger(BankController.class);

	/**
	 * Nastaveni metody Get.
	 *
	 * @param request
	 *            zadost
	 * @param res
	 *            odpoved servletu
	 * @param model
	 *            model
	 * @return the string
	 * @throws Exception
	 *             vyjimka
	 */
	@RequestMapping(value = ACTION, method = RequestMethod.GET)
	public String get(final HttpServletRequest request, final HttpServletResponse res, final ModelMap model) throws Exception {
		final GameCode gameCode = WebUtils.getGameCode(request);

		if (gameCode != null) {

			final Game game = gameCode.getGame();
			final List<FinancialAssets> financialAssets = ppzService.getFinancialAssetsByAvatar(game.getAvatar());
			model.addAttribute("products", financialAssets);

		}

		return ACTION;
	}

	/**
	 * Zobrazeni stranky pro pridani produktu.
	 *
	 * @param request
	 *            zadost
	 * @param res
	 *            odpoved servletu
	 * @param model
	 *            model
	 * @return the adds the
	 * @throws Exception
	 *             vyjimka
	 */
	@RequestMapping(value = ACTION_ADD, method = RequestMethod.GET)
	public String getAdd(final HttpServletRequest request, final HttpServletResponse res, final ModelMap model) throws Exception {
		final GameCode gameCode = WebUtils.getGameCode(request);

		if (gameCode != null) {

			final Game game = gameCode.getGame();
			final List<FinancialAssets> financialAssets = ppzService.getFinancialAssetsByAvatar(game.getAvatar());
			model.addAttribute("products", financialAssets);

		}

		model.addAttribute("product", new FinancialAssets());

		return ACTION;
	}

	/**
	 * Odstraneni
	 *
	 * @param id
	 *            identifikacni cislo
	 * @param request
	 *            zadost
	 * @param res
	 *            the res
	 * @param model
	 *            model
	 * @return the removes the
	 * @throws Exception
	 *             vyjimky
	 */
	@RequestMapping(value = ACTION_REMOVE, method = RequestMethod.GET)
	public String getRemove(@RequestParam("id") final Long id, final HttpServletRequest request, final HttpServletResponse res, final ModelMap model) throws Exception {
		final GameCode gameCode = WebUtils.getGameCode(request);

		if (gameCode != null) {

			final Game game = gameCode.getGame();
			final FinancialAssets financialAssets = ppzService.getFinancialAssets(id);
			// zjistime zda maze produkt ktery se vztahuje k jeho avataru
			if (game.getAvatar().getAvatarId().equals(financialAssets.getAvatar().getAvatarId())) {
				ppzService.deleteFinancialAssets(financialAssets);
			}

		}

		return REDIRECT;
	}

	/**
	 * pridani produktu.
	 *
	 * @param product
	 *            the product
	 * @param result
	 *            the result
	 * @param model
	 *            the model
	 * @param request
	 *            the request
	 * @return the string
	 * @throws Exception
	 *             the exception
	 */
	@RequestMapping(value = ACTION_ADD, method = RequestMethod.POST)
	public String postAdd(@ModelAttribute(value = "product") final FinancialAssets product, final BindingResult result, final ModelMap model, final HttpServletRequest request) throws Exception {
		final GameCode gameCode = WebUtils.getGameCode(request);

		if (gameCode != null && gameCode.getGame() != null) {
			final Avatar avatar = gameCode.getGame().getAvatar();
			product.setAvatar(avatar);
			product.setType(Enums.FinancialAssetsEnum.INVESTMENT_EQUITY_FUND.getCode());
		}

		ppzService.createFinancialAssets(product);

		return REDIRECT;
	}

	/**
	 * Editace volani z db pomoci Ajaxu
	 *
	 * @param id
	 *            the id
	 * @param value
	 *            the value
	 * @return the string
	 */
	public String edit(final String id, final String value) {
		final BigDecimal bd = new BigDecimal(value);
		final FinancialAssets fa = ppzService.getFinancialAssets(Long.parseLong(id));
		fa.setValue(bd);
		ppzService.updateFinancialAssets(fa);
		return id;
	}

}