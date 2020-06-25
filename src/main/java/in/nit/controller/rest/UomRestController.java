package in.nit.controller.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import in.nit.model.UomType;
import in.nit.service.IUomTypeService;

@RestController
@RequestMapping("/rest/uom")
public class UomRestController {
	@Autowired
	private IUomTypeService service;

	@GetMapping("/all")
	public ResponseEntity<?> fetchAllUomTypes(){

		ResponseEntity<?> resp =null;

		try {
			List<UomType> uoms=  service.displayAllUomTypes();

			if(uoms!=null && !uoms.isEmpty()) {
				resp= new ResponseEntity<List<UomType>>(uoms, HttpStatus.OK);
			}else {
				//resp=new ResponseEntity<String>("No UOMS Found", HttpStatus.NO_CONTENT);
				resp=new ResponseEntity<String>(HttpStatus.NO_CONTENT);
			}

		} catch (Exception e) {
			resp=new ResponseEntity<String>("Unable To Fetch Data", HttpStatus.INTERNAL_SERVER_ERROR);
			e.printStackTrace();
		}
		return resp;
	}

	@GetMapping("/one")
	public ResponseEntity<?> fetchOneUom(
			@RequestParam ("id")Integer id
			){
		ResponseEntity<?> resp=null;
		try {
			UomType uom=service.getOneUomType(id);

			if(uom!=null) {
				resp=new ResponseEntity<UomType>(uom, HttpStatus.OK);
			}else {
				resp=new ResponseEntity<String>("Uom '"+id+"'not exist", HttpStatus.BAD_REQUEST);
			}
		} catch (Exception e) {
			resp=new ResponseEntity<String>("Unable To Fetch The Data", HttpStatus.INTERNAL_SERVER_ERROR);
			e.printStackTrace();
		}
		return resp;
	}

	@DeleteMapping("/remove")
	public ResponseEntity<String> removeUom(
			@RequestParam ("id")Integer id
			){
		ResponseEntity<String> resp=null;
		try {
			service.deleteUomById(id);
			resp=new ResponseEntity<String>("UomType'"+id+"'Deleted", HttpStatus.OK);
		} catch (Exception e) {
			resp=new ResponseEntity<String>("UomType'"+id+"'not exist", HttpStatus.INTERNAL_SERVER_ERROR);
			e.printStackTrace();
		}
		return resp;
	}

	@PostMapping("/save")
	public ResponseEntity<String> saveUomType( @RequestBody UomType uomType){
		ResponseEntity<String> resp=null;
		try {
			Integer id= service.saveUomType(uomType);
			resp=new ResponseEntity<String>("Uom'"+id+"'Saved", HttpStatus.CREATED);
		}
		catch (Exception e) {
			resp=new ResponseEntity<String>("Unable To Save The Uom", HttpStatus.INTERNAL_SERVER_ERROR);
			e.printStackTrace();
		}
		return resp;
	}
	
	@PutMapping("/update")
	public ResponseEntity<String> saveUom(@RequestBody UomType uomType){
		ResponseEntity<String> resp=null;
		try {
			service.updateUomType(uomType);
			resp=new ResponseEntity<String>("Uom'"+uomType.getUomId()+"' Updated", HttpStatus.RESET_CONTENT);
		} catch (Exception e) {
			resp=new ResponseEntity<String>("Uom '"+uomType.getUomId()+"' Not Exist", HttpStatus.INTERNAL_SERVER_ERROR);
			e.printStackTrace();
		}
		return resp;
	}

}//class
