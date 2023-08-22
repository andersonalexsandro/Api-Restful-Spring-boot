package med.voll.api.useful;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.modelmapper.ModelMapper;


@Component
public class EntityMapper {

//    @Autowired
    private static final ModelMapper modelMapper = new ModelMapper();

    public static <D, T> T mapDTOToEntity(D dto, Class<T> entity){
        return modelMapper.map(dto, entity);
    }
}

