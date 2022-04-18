package dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
@AllArgsConstructor
public class Project {
    String name,
            code,
            descriptions,
            accessType,
            membersAccess,
            group;
}
