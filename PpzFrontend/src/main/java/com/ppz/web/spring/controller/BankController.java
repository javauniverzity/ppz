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
import com.ppz.web.service.PpzService;
import com.ppz.web.service.UserService;
import com.ppz.web.utils.Enums;
import com.ppz.web.utils.WebUtils;

/**
 * Stranka PPZ
 * 
 * @author Pavel Lukes
 *
 */

@Controller
public class BankController {
	
	public static final String ACTION = "bank";
	public static final String ACTION_ADD = "bankAdd";
	public static final String ACTION_REMOVE = "bankRemove";
	public static final String REDIRECT = "redirect:" + ACTION + ".html";
	
	@Autowired
	UserService userService;
	
	@Autowired
	PpzService ppzService;
	

	Logger logger = Logger.getLogger(BankController.class);
	
	@RequestMapping(value = ACTION, method = RequestMethod.GET)
	public String get(HttpServletRequest request, HttpServletResponse res, ModelMap model) throws Exception {
		GameCode gameCode = WebUtils.getGameCode(request);
		
		if (gameCode != null) {

			Game game = gameCode.getGame();
			List<FinancialAssets> financialAssets = ppzService.getFinancialAssetsByAvatar(game.getAvatar());
			model.addAttribute("products", financialAssets);

		}
		
		
		return ACTION;
	}

	/**
	 * zobrazeni stranky pro pridani produktu
	 * 
	 * @param request
	 * @param res
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = ACTION_ADD, method = RequestMethod.GET)
	public String getAdd(HttpServletRequest request, HttpServletResponse res, ModelMap model) throws Exception {
		GameCode gameCode = WebUtils.getGameCode(request);
		
		if (gameCode != null) {

			Game game = gameCode.getGame();
			List<FinancialAssets> financialAssets = ppzService.getFinancialAssetsByAvatar(game.getAvatar());
			model.addAttribute("products", financialAssets);

		}
		
		model.addAttribute("product", new FinancialAssets());
		
		
		return ACTION;
	}
	
	@RequestMapping(value = ACTION_REMOVE, method = RequestMethod.GET)
	public String getRemove(@RequestParam("id") Long id, HttpServletRequest request, HttpServletResponse res, ModelMap model) throws Exception {
		GameCode gameCode = WebUtils.getGameCode(request);
		
		if (gameCode != null) {

			Game game = gameCode.getGame();
			FinancialAssets financialAssets = ppzService.getFinancialAssets(id);
			// zjistime zda maze produkt ktery se vztahuje k jeho avataru
			if (game.getAvatar().getAvatarId().equals(financialAssets.getAvatar().getAvatarId())) {
				ppzService.deleteFinancialAssets(financialAssets);
			}

		}
		
		return REDIRECT;
	}
	
	/**
	 * pridani produktu
	 * 
	 * @param product
	 * @param result
	 * @param model
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = ACTION_ADD, method = RequestMethod.POST)
	public String postAdd(@ModelAttribute(value="product") FinancialAssets product, BindingResult result, ModelMap model, HttpServletRequest request) throws Exception {
		GameCode gameCode = WebUtils.getGameCode(request);
		
		if (gameCode != null && gameCode.getGame() != null) {
			Avatar avatar = gameCode.getGame().getAvatar();
			product.setAvatar(avatar);
			product.setType(Enums.FinancialAssetsEnum.INVESTMENT_EQUITY_FUND.getCode());
		}

		ppzService.createFinancialAssets(product);

		return REDIRECT;
	}
	
	/**
	 * Editace volána z dwr pomocí ajaxu
	 * 
	 * @return
	 */
	public String edit(String id, String value) {
		BigDecimal bd = new BigDecimal(value);
		FinancialAssets fa = ppzService.getFinancialAssets(Long.parseLong(id));
		fa.setValue(bd);
		ppzService.updateFinancialAssets(fa);
		return id;
	}

}