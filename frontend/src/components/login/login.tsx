import React from 'react';
import { GoogleOAuthProvider } from '@react-oauth/google';
import { GoogleLogin } from '@react-oauth/google';
import jwt_decode from 'jwt-decode';

function myFunction(value: string) {
    console.log(value);
  }
  
  const myString: string | undefined = undefined;
  
  if (myString !== undefined) {
    myFunction(myString);
  } else {
    console.log('myString is undefined');
  }
    const App: React.FC = () => {
        return (
          <div className='main-container'>
            <GoogleOAuthProvider clientId="436159769817-cdrkajr7gveupiqsj4o2ej693sotaef1.apps.googleusercontent.com">
              <GoogleLogin
                onSuccess={(credentialResponse) => {
                  const credential = credentialResponse.credential ?? '';
                  const details = jwt_decode(credential);
                  console.log(details);
                  console.log(credentialResponse);
                }}
                theme='filled_black'
                shape='pill'
                onError={() => {
                  console.log('Login Failed');
                }}
              />
            </GoogleOAuthProvider>
          </div>
        );
      };
      

export default App;
