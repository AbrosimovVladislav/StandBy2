export const get = async (url) => {
  const response = await fetch(url)
  .then(r => {
    const resp = r.json()
    console.log("GET for: " + url + " result: " + JSON.stringify(resp))
    return resp
  })
  .catch((error) => {
    console.log(error)
  });
  return response;
}