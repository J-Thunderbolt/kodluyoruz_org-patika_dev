using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class PlayerController : MonoBehaviour
{
    public float horizontalInput;
    private float speed = 20.0f;
    public float xRange = 10.0f;
    public GameObject projectilePrefab;
    void Start()
    {

    }

    void Update()
    {
        if (transform.position.x < -xRange)
        {
            transform.position = new Vector3(1, 0, 0) * -xRange;
        }
        if (transform.position.x > xRange)
        {
            transform.position = new Vector3(1, 0, 0) * xRange;
        }

        horizontalInput = Input.GetAxis("Horizontal");
        transform.Translate(Vector3.right * horizontalInput * speed * Time.deltaTime);

        if (Input.GetKeyDown(KeyCode.Space))
        {
            Instantiate(projectilePrefab, transform.position, projectilePrefab.transform.rotation);
        }

    }
}
