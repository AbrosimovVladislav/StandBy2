const initialState = {
  menuItems: [{
    "id": 1,
    "name": "Матчи",
    "routerLink": "/competitions",
  },
    {
      "id": 5,
      "name": "Тест",
      "routerLink": "",
    },
  ]
};

export default function menuReducer(state = initialState, action) {
  switch (action.type) {
    default :
      return state;
  }
}