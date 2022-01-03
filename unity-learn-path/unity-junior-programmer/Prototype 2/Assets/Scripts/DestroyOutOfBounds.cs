using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class DestroyOutOfBounds : MonoBehaviour
{
    private float topBoundary = 30.0f;
    private float lowerBoundary = -10.0f;
    private float sideBoundary = 30.0f;
    void Start()
    {

    }

    void Update()
    {
        if (transform.position.z > topBoundary)
        {
            Destroy(gameObject);
        }
        else if (transform.position.z < lowerBoundary)
        {
            Destroy(gameObject);
        }
        else if (transform.position.x > sideBoundary)
        {
            Destroy(gameObject);
        }
        else if (transform.position.x < -sideBoundary)
        {
            Destroy(gameObject);
        }
    }
}
