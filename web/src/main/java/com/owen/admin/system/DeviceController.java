package com.owen.admin.system;

import com.owen.*;
import com.owen.dao.repository.IGroupDao;
import com.owen.service.IDeviceService;
import com.owen.service.IGroupService;
import com.owen.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import com.owen.JsonResult;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/admin/device")
public class DeviceController extends BaseController {

    @Autowired
    private IDeviceService deviceService;
    @Autowired
    private IGroupService groupService;
    @Autowired
    private IUserService userService;

    @Autowired
    private IGroupDao groupDao;

    @RequestMapping(value = { "/", "/index" })
    public String index() {
        return "admin/device/index";
    }

    @RequestMapping(value = { "/list" })
    @ResponseBody
    public Page<Device> list(@RequestParam(value="searchText",required=false) String searchText){
        Page<Device> page=deviceService.findAllByLike(searchText, getPageRequest());
        return page;
    }

    @RequestMapping(value = "/mylist" )
    public String myList() {
        return "admin/device/mylist";
    }


    @RequestMapping(value = "/mydevice" )
    @ResponseBody
    public Page<Device> mydevice() throws NullPointerException{
            HttpSession session=request.getSession();
            User user= (User) session.getAttribute("userObject");
            Group group=groupDao.selectGroupByName(user.getId());
            Integer s;
            if(group==null){
                s=0;
            }else{
                s=group.getId();
            }
            String searchText=Integer.toString(s);
            Page<Device> page=deviceService.assGroupId(searchText, getPageRequest());
            return page;
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String add(ModelMap map) {
        return "admin/device/form";
    }


    @RequestMapping(value= {"/dedit"} ,method = RequestMethod.POST)
    @ResponseBody
    public JsonResult dedit(Device device,ModelMap map){

        try {
            deviceService.saveOrUpdate(device);
            Device device1=deviceService.queryAllByDeviceSn(device.getDeviceSn());
            deviceService.grant(device1.getId(),Integer.parseInt(device1.getGroupId()));
        } catch (Exception e) {
            return JsonResult.failure(e.getMessage());
        }
        return JsonResult.success();
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String edit(@PathVariable Integer id, ModelMap map) {
        Device device=deviceService.find(id);
        map.put("device",device);
        return "admin/device/form";
    }



    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
    @ResponseBody
    public JsonResult delete(@PathVariable Integer id,ModelMap map) {
        try {
            deviceService.delete(id);
        } catch (Exception e) {
            e.printStackTrace();
            return JsonResult.failure(e.getMessage());
        }
        return JsonResult.success();
    }


}
