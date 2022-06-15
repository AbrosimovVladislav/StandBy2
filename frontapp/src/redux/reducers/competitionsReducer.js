import {PUT_COMPETITIONS, PUT_CURRENT_COMPETITION} from "../actions";

const initialState = {
  competitions: [
    {
      id: '1',
      name: 'TestCompetition1',
      date: '23.06.2022-27.06.2022',
      level: 'IPSC (Level III)',
      type: 'Handgun',
      place: 'Russia, Saint-Petersburg, p.Pesochny, st. Pioneer 88, SSK Nevsky',
      numberOfStages: '20',
      numberOfSquads: '20',
      squadSize: '5',
      numberOfShooters: '100',
      price: '8000',
      organizer: 'Nevsky',
      description: ''
    },
    {
      id: '2',
      name: 'TestCompetition2',
      date: '23.06.2022-27.06.2022',
      level: 'IPSC (Level III)',
      type: 'Handgun',
      place: 'Russia, Saint-Petersburg, p.Pesochny, st. Pioneer 88, SSK Nevsky',
      numberOfStages: '20',
      numberOfSquads: '20',
      squadSize: '5',
      numberOfShooters: '100',
      price: '8000',
      organizer: 'Nevsky',
      description: ''
    },
    {
      id: '3',
      name: 'TestCompetition3',
      date: '23.06.2022-27.06.2022',
      level: 'IPSC (Level III)',
      type: 'Handgun',
      place: 'Russia, Saint-Petersburg, p.Pesochny, st. Pioneer 88, SSK Nevsky',
      numberOfStages: '20',
      numberOfSquads: '20',
      squadSize: '5',
      numberOfShooters: '100',
      price: '8000',
      organizer: 'Nevsky',
      description: ''
    },
  ],
  currentCompetition: {
    id: '1',
    name: 'TestCompetition1',
    date: '23.06.2022-27.06.2022',
    level: 'IPSC (Level III)',
    type: 'Handgun',
    place: 'Russia, Saint-Petersburg, p.Pesochny, st. Pioneer 88, SSK Nevsky',
    numberOfStages: '20',
    numberOfSquads: '20',
    squadSize: '5',
    numberOfShooters: '100',
    price: '8000',
    organizer: 'Nevsky',
    description: '',
    results: {
      overall: [
        {
          place: '1',
          percentage: '100%',
          points: '1234',
          competitor: 'Ivan Ivanov',
          competitorsRank: 'M',
          type: 'Handgun',
          class: 'production',
          region: 'RUS'
        },
        {
          place: '2',
          percentage: '90%',
          points: '1134',
          competitor: 'Petr Ivanov',
          competitorsRank: 'M',
          type: 'Handgun',
          class: 'production',
          region: 'RUS'
        },
        {
          place: '3',
          percentage: '80%',
          points: '1034',
          competitor: 'Vasiliy Ivanov',
          competitorsRank: 'M',
          type: 'Handgun',
          class: 'production',
          region: 'RUS'
        }
      ]
    }
  }
};

export default function competitionsReducer(state = initialState, action) {
  switch (action.type) {
    case PUT_COMPETITIONS :
      const competitions = action.payload;
      return {...state, competitions: competitions};
    case PUT_CURRENT_COMPETITION :
      const currentCompetition = action.payload;
      return {...state, currentCompetition: currentCompetition};
    default :
      return state;
  }
}