package action;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ErrorController {
	@RequestMapping("/error")
	public ModelAndView handle(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("errorMessage");
		
		Object status = request.getAttribute("javax.servlet.error.status_code");
		Object message = request.getAttribute("javax.servlet.error.message");
		
		Map<String, Object> modelMap = new HashMap<String, Object>();
		modelMap.put("status", status);
		modelMap.put("message", message);
		
		return mav.addAllObjects(modelMap);
	}
}
