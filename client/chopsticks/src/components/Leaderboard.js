import React, { useState } from 'react';
import { useParams } from 'react-router-dom';
import SockJsClient from "react-stomp";
import { useNavigate } from 'react-router-dom';
import { useRef, useEffect} from "react";
import axios from "axios";

import { useNavigate } from 'react-router-dom';
import { auth } from '..';
import { database } from '..';
import axios from "axios";

function Leaderboard() {
  const data =[{"name":"test1"},{"name":"test2"}];
  const listItems = data.map((d) => <li key={d.name}>{d.name}</li>);
  
  return (
      <div>
      {listItems }
      </div>
    );
}
export default Leaderboard;
