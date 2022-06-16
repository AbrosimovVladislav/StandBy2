package pro.standby.web.mapper;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pro.standby.model.Competition;
import pro.standby.model.dto.CompetitionDto;
import pro.standby.model.dto.result.CompetitionDetails;
import pro.standby.service.PersonService;
import pro.standby.service.RefereeService;
import pro.standby.service.resultCalculator.ResultCalculator;

import java.util.Date;
import java.util.List;

@Component
@RequiredArgsConstructor
public class CompetitionMapper {

    private final PersonService personService;
    private final RefereeService refereeService;
    private final ResultCalculator resultCalculator;

    public List<CompetitionDetails> competitions2DetailsList(List<Competition> competitions) {
        return competitions.stream()
                .map(this::competition2Details)
                .toList();
    }

    public List<CompetitionDto> competitions2Dtos(List<Competition> competitions) {
        return competitions.stream()
                .map(this::competition2Dto)
                .toList();
    }

    public CompetitionDto competition2Dto(Competition competition) {
        return CompetitionDto.builder()
                .competitionId(competition.getCompetitionId())
                .name(competition.getName())
                .startDate(competition.getStartDate().toString())
                .finishDate(competition.getFinishDate().toString())
                .place(competition.getPlace())
                .organizer(competition.getOrganizer())
                .price(competition.getPrice())
                .description(competition.getDescription())
                .level(competition.getLevel())
                .gunType(competition.getGunType())
                .referee(competition.getReferee().getPerson().getFirstName() + " "
                        + competition.getReferee().getPerson().getLastName())
                .matchDirector(competition.getMatchDirector().getFirstName() + " "
                        + competition.getMatchDirector().getFirstName())
                .build();
    }

    public CompetitionDetails competition2Details(Competition competition) {
        return CompetitionDetails.builder()
                .competition(competition)
                .overallResults(resultCalculator.calculateOverallResults(competition))
                .competitionResultStageView(resultCalculator.calculateStageViewResults(competition))
                .competitorViewResults(null)
                .build();
    }

    public Competition dto2competition(CompetitionDto competitionDto) {
        String refFirstName = competitionDto.getReferee().split(" ")[0];
        String refLastName = competitionDto.getReferee().split(" ")[1];
        String matchDirectorFirstName = competitionDto.getMatchDirector().split(" ")[0];
        String matchDirectorLastName = competitionDto.getMatchDirector().split(" ")[1];

        return new Competition()
                .setName(competitionDto.getName())
                .setStartDate(prepareDate(competitionDto.getStartDate()))
                .setFinishDate(prepareDate(competitionDto.getFinishDate()))
                .setPlace(competitionDto.getPlace())
                .setOrganizer(competitionDto.getOrganizer())
                .setPrice(competitionDto.getPrice())
                .setDescription(competitionDto.getDescription())
                .setLevel(competitionDto.getLevel())
                .setGunType(competitionDto.getGunType())
                .setReferee(refereeService.findByName(refFirstName, refLastName))
                .setMatchDirector(personService.findByName(matchDirectorFirstName, matchDirectorLastName));
    }

    /**
     * 16.06.2022
     **/
    private Date prepareDate(String date) {
        String[] splited = date.split("\\.");
        return new Date(
                Integer.parseInt(splited[2]),
                Integer.parseInt(splited[1]),
                Integer.parseInt(splited[0])
        );
    }

}
