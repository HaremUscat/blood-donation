package ro.ubb.donation.web.converter;

import org.springframework.stereotype.Component;
import ro.ubb.donation.core.model.User;
import ro.ubb.donation.web.dto.UserDto;

@Component
public class UserConverter extends AbstractConverter<User, UserDto> implements Converter<User, UserDto> {
    @Override
    public User convertDtoToModel(UserDto userDto) {
        return null;
    }

    @Override
    public UserDto convertModelToDto(User user) {
        return null;
    }
}
