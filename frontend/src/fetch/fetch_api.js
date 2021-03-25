export function fetchGetCall(url) {
    return fetch(url)
    .then(r=>{
        return r.json();
    })
    .then(r=>{
        return r;
    })
}